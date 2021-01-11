import React from "react";
import { Row, Col, Card, Button } from "antd";

function ItemDetProdotto(props) {
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
          <h3>Titolo prodotto{props.nome}</h3>
          <Button onClick={() => props.myFunc()}>Chiudi</Button>
          <Button onClick={() => props.myFunc()}>Aggiungi</Button>
        </Col>
      </Row>
    </Card>
  );
}

export default ItemDetProdotto;
