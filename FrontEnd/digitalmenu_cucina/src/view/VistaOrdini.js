import React, { useContext, useState, useEffect } from "react";
import DigitalMenuService from "../services/DigitalMenuService";
import { Button, Layout, Row, Col } from "antd";
import ItemOrdine from "../components/ItemOrdine";
import Title from "antd/lib/typography/Title";

const { Header, Footer, Content } = Layout;

function BarState(props) {
  let stile = {
    position: "absolute",
    width: "100%",
    height: "9px",
    top: "0",
    left: "0",
  };

  if (props.stato == 0) {
    stile.backgroundColor = "red";
  }
  if (props.stato == 1) {
    stile.backgroundColor = "orange";
  }
  if (props.stato == 2) {
    stile.backgroundColor = "green";
  }

  return <div style={stile}></div>;
}

function VistaOrdini() {
  const [ordini, setOrdini] = useState([]);

  useEffect(() => {
    function aggiorna() {
      let b = DigitalMenuService.getOrdini();
      b.then((res) => {
        setOrdini(res.data);
        console.log(res.data);
      });
    }
    aggiorna();
    const interval = setInterval(() => aggiorna(), 900);
    return () => {
      clearInterval(interval);
    };
  }, []);

  return (
    <Layout>
      <Header>
        <Title type="warning"> Ordini in Arrivo</Title>
      </Header>
      <Content
        style={{
          overflow: "auto",
        }}
      >
        <Row
          style={{
            width: "100%",
          }}
        >
          {ordini.map((value, i) => {
            return (
              <ItemOrdine
                key={i}
                onClick={() => {
                  DigitalMenuService.setStato(value.ordineId);
                }}
                ordine={value}
              >
                <Title> ORDINE {value.ordineId}</Title>
                <Title level={5}>
                  {" "}
                  STATO: {value.stato == 0 && "NON PAGATO"}
                  {value.stato == 1 && "IN ATTESA"}
                  {value.stato == 2 && "IN PREPARAZIONE"}{" "}
                  {value.stato == 3 && "IN ARRIVO"}
                </Title>
                {value.stato == 0 && <BarState stato={0} />}
                {value.stato == 1 && <BarState stato={1} />}
                {value.stato == 2 && <BarState stato={2} />}{" "}
                {value.stato == 3 && <BarState stato={2} />}
              </ItemOrdine>
            );
          })}
        </Row>
      </Content>
      <Footer></Footer>
    </Layout>
  );
}

export default VistaOrdini;
