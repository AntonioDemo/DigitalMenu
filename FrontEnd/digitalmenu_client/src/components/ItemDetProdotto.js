import React, { useContext } from "react";
import { Row, Col, Card, Button } from "antd";
import CarrelloContext from "../context/CarrelloContext";

function ItemDetProdotto(props) {
  const [carrelloContext, setContext] = useContext(CarrelloContext);
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
        height: "90%",
        margin: "5px",
        padding: "0px",
        boxShadow:
          " 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19)",
      }}
    >
      <Row>
        <Col>
          <img
            alt={"prodotto"}
            src={
              "https://i0.wp.com/www.sicilianicreativiincucina.it/wp-content/uploads/2018/06/linguine-con-vongole.jpg?fit=700%2C686&ssl=1"
            }
            style={{
              width: "80%",
              display: "block",
              marginLeft: "auto",
              marginRight: "auto",
            }}
          ></img>
        </Col>
      </Row>
      <Row style={{ margin: "5px" }}>
        <Col style={{ margin: "auto" }}>
          <h3>{props.nome}</h3>
          <h3>{props.prezzo}</h3>
          <h3>Lista Ingredienti</h3>
          {props.listIng.map((value, i) => {
            return <p key={i}> {value.nomeIng} </p>;
          })}
          <Button onClick={() => props.funSetHidden()}>Chiudi</Button>
          <Button
            onClick={() => {
              let obj = new Object();
              obj.prodotto = { nome: "DMA", prodottoId: 3, prezzo: 7 };
              obj.quantita = 5;
              obj.rimIng = "immmmagginne";

              setContext((previousState) => {
                return { listaProdotti: [...previousState.listaProdotti, obj] };
              });

              console.log(carrelloContext);
              console.log(obj);
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
