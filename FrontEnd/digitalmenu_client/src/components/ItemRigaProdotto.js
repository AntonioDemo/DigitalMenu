import React, { useContext } from "react";
import { Row, Col } from "antd";
import { Button } from "antd";
import { DeleteOutlined } from "@ant-design/icons";
import CarrelloContext from "../context/CarrelloContext";

function deleteProdotto(lista, indice) {
  let prezzoDaSottrarre = 0;
  for (var i = 0; i < lista.length; i++) {
    if (lista[i].prodotto.prodottoId === indice) {
      prezzoDaSottrarre = lista[i].prodotto.prezzo;
      lista.splice(i, 1);
      i--;
    }
  }
  return prezzoDaSottrarre;
}

function ItemRigaProdotto(props) {
  const [carrelloContext, setContext] = useContext(CarrelloContext);

  return (
    <Row
      style={{
        backgroundColor: "grey",
        padding: "5px",
      }}
    >
      <Col flex="auto"> {props.nome} </Col>
      <Col flex="100px">Quantità: {props.qta}</Col>
      <Col flex="100px">Prezzo: {props.prezzo}</Col>
      <Col flex="100px">
        <Button
          onClick={() => {
            let contestoClone = { ...carrelloContext };

            let prezzoDaSottrarre = deleteProdotto(
              contestoClone.listaProdotti,
              props.prodottoId
            );

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
