import React, { useContext, useState } from "react";
import { Row, Col, Card, Button } from "antd";
import CarrelloContext from "../context/CarrelloContext";
import Title from "antd/lib/typography/Title";
import { Switch } from "antd";
import { CloseOutlined, CheckOutlined } from "@ant-design/icons";

function ItemDetProdotto(props) {
  const [carrelloContext, setContext] = useContext(CarrelloContext);
  const [qta, setQta] = useState(1);
  return (
    <Card
      hidden={props.setHidden}
      onClick={() => {}}
      hoverable
      bodyStyle={{ padding: "5px" }}
      style={{
        position: "fixed",
        zIndex: "1000",
        display: "inline-block",
        width: "80%",
        height: "80%",
        margin: "5px",
        padding: "0px",
        boxShadow:
          " 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19)",
      }}
    >
      <Row>
        <Col
          style={{
            width: "100%",
          }}
        >
          <img
            alt={"prodotto"}
            src={"http://localhost:8080/" + props.foto}
            style={{
              width: "30vh",
              marginLeft: "auto",
              marginRight: "auto",
            }}
          ></img>
        </Col>
      </Row>
      <Row style={{ margin: "5px" }}>
        <Col style={{ margin: "auto" }}>
          <Title>{props.nome}</Title>
        </Col>
      </Row>
      <Row>
        <Col style={{ width: "100%", textAlign: "left", marginLeft: "10px" }}>
          <Title level={2}>Lista Ingredienti</Title>
          {props.listIng !== undefined &&
            props.listIng.map((value, i) => {
              return (
                <p key={i}>
                  {value.nomeIng}
                  {value.isRimovibile == true && (
                    <Switch
                      checkedChildren={<CheckOutlined />}
                      unCheckedChildren={<CloseOutlined />}
                      defaultChecked
                    />
                  )}
                </p>
              );
            })}
        </Col>
      </Row>
      <Row style={{ margin: "5px" }}>
        <Col style={{ width: "50%" }}>
          <Button
            onClick={() => {
              if (qta !== 1) {
                setQta(qta - 1);
              }
            }}
          >
            -
          </Button>
          <Button>quantita {qta}</Button>
          <Button
            onClick={() => {
              setQta(qta + 1);
            }}
          >
            +
          </Button>
        </Col>
        <Col style={{ width: "50%" }}>
          <Title level={3}>Prezzo {props.prezzo}€ </Title>
        </Col>
      </Row>
      <Row style={{ margin: "5px" }}>
        <Col style={{ width: "50%" }}>
          <Button
            onClick={() => {
              setQta(1);
              props.funSetHidden();
            }}
          >
            Chiudi
          </Button>
        </Col>
        <Col style={{ width: "50%" }}>
          <Button
            onClick={() => {
              let obj = {};
              obj.prodotto = { nome: "DMA", prodottoId: 3, prezzo: 7 };
              obj.quantita = qta;
              obj.rimIng = "immmmagginne";

              setContext((previousState) => {
                return { listaProdotti: [...previousState.listaProdotti, obj] };
              });

              console.log(carrelloContext);
              console.log(obj);
              setQta(1);
              props.funSetHidden();
            }}
          >
            Aggiungi
          </Button>
        </Col>
      </Row>
    </Card>
  );
}

export default ItemDetProdotto;
