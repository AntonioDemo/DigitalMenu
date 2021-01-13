import React, { useContext } from "react";
import { Row, Col, Card } from "antd";
import CarrelloContext from "../context/CarrelloContext";

function ItemCategoria(props) {
  const [carrelloContext, setContext] = useContext(CarrelloContext);
  return (
    <Card
      onClick={() => {
        let contestoClone = { ...carrelloContext };
        contestoClone.categoriaSelezionata = props.categoriaId;
        setContext(contestoClone);
      }}
      hoverable
      style={{ margin: "5px" }}
      bodyStyle={{ padding: "10px" }}
    >
      <Row style={{ margin: "0px", padding: "0px" }}>
        <Col style={{ width: "100%" }}>
          <img
            alt={"prova"}
            src={
              "https://i0.wp.com/www.sicilianicreativiincucina.it/wp-content/uploads/2018/06/linguine-con-vongole.jpg?fit=700%2C686&ssl=1"
            }
            style={{
              width: "90%",
              display: "block",
              marginLeft: "auto",
              marginRight: "auto",
            }}
          ></img>
        </Col>
      </Row>
      <Row>
        <Col style={{ margin: "auto" }}>
          <h2>{props.nome}</h2>
        </Col>
      </Row>
    </Card>
  );
}

export default ItemCategoria;
