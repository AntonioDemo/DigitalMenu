import React, { useContext } from "react";
import { Row, Col, Card } from "antd";
import CarrelloContext from "../context/CarrelloContext";

function ItemProdotto(props) {
  const [carrelloContext, setContext] = useContext(CarrelloContext);
  return (
    <Card
      onClick={() => {
        let contestoClone = { ...carrelloContext };
        contestoClone.prodottoSelezionato = props.id;
        setContext(contestoClone);
        console.log("CARRELLO CONTEXT ITEMPRODOTTO", carrelloContext);
        props.funSetHidden();
      }}
      hoverable
      bodyStyle={{ padding: "5px" }}
      style={{
        display: "inline-block",
        width: "30%",
        margin: "5px",
        padding: "0px",
      }}
    >
      <Row>
        <Col>
          <img
            alt={"prodotto"}
            src={"http://localhost:8080/" + props.foto}
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
        </Col>
        <div
          style={{
            right: "0",
            bottom: "0",
            marginRight: "-10px",
            marginBottom: "-10px",
            width: "80px",
            height: "30px",
            backgroundColor: "orange",
            position: "absolute",
            zindex: "1000",
          }}
        >
          <h3>{props.prezzo}€</h3>
        </div>
      </Row>
    </Card>
  );
}

export default ItemProdotto;
