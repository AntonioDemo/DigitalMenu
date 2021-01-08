import React from "react";
import { Row, Col, Card, Button } from "antd";

function ItemRigaProdotto(props) {
  return (
    <Row
      style={{
        backgroundColor: "grey",
        padding: "5px",
      }}
    >
      <Col flex="auto">Nome prodotto</Col>
      <Col flex="100px">Quantità: n</Col>
      <Col flex="100px">Prezzo: n</Col>
      <Col flex="100px">imgg</Col>
    </Row>
  );
}

export default ItemRigaProdotto;
