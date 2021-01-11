import React from "react";
import { Row, Col } from "antd";

function ItemRigaProdotto(props) {
  return (
    <Row
      style={{
        backgroundColor: "grey",
        padding: "5px",
      }}
    >
      <Col flex="auto"> {props.nome}</Col>
      <Col flex="100px">Quantità: {props.qta}</Col>
      <Col flex="100px">Prezzo: {props.prezzo}</Col>
      <Col flex="100px">DEL</Col>
    </Row>
  );
}

export default ItemRigaProdotto;
