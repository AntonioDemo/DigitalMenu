import React, { useContext } from "react";
import { Row, Col } from "antd";
import { Button } from "antd";
import { DeleteOutlined } from "@ant-design/icons";
import CarrelloContext from "../context/CarrelloContext";

function deleteProdotto(lista, indice) {
  console.log("DELETE_PRODOTTO", indice, lista);
  let prezzoDaSottrarre = 0;
  for (var i = 0; i < lista.length; i++) {
    if (i === indice) {
      prezzoDaSottrarre = lista[i].prodotto.prezzo;
      lista.splice(i, 1);
    }
  }
  return prezzoDaSottrarre;
}

function ItemRigaProdotto(props) {
  const [carrelloContext, setContext] = useContext(CarrelloContext);

  return (
    <Row
      style={{
        backgroundColor: "#ffffff",
        padding: "5px",
        fontSize: "large",
      }}
    >
      <Col flex="auto"> {props.nome} </Col>
      <Col flex="100px">Quantità: {props.qta}</Col>
      <Col flex="100px">Prezzo: {props.prezzo}€</Col>
      <Col flex="100px">
        <Button
          onClick={() => {
            let contestoClone = { ...carrelloContext };

            let prezzoDaSottrarre = deleteProdotto(
              contestoClone.listaProdotti,
              props.id
            );
            console.log("MAMAMAMAMAM", props.id);
            contestoClone.prezzoTotale -= prezzoDaSottrarre;
            setContext(contestoClone);
            console.log(
              "CONTEXT CLONE IN ITEMRIGA DOPO  FUN DELETEPRODOTTO:",
              contestoClone
            );
            console.log(
              "CONTEXT  IN ITEMRIGA DOPO  FUN DELETEPRODOTTO:",
              carrelloContext
            );
          }}
          danger
          type="primary"
          icon={<DeleteOutlined />}
        />
      </Col>
    </Row>
  );
}

export default ItemRigaProdotto;
