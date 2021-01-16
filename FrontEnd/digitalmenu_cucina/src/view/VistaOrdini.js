import React, { useContext, useState, useEffect } from "react";
import DigitalMenuService from "../services/DigitalMenuService";
import { Button, Layout } from "antd";
import ItemOrdine from "../components/ItemOrdine";
import Title from "antd/lib/typography/Title";

const { Header, Footer, Sider, Content } = Layout;

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
      <Content>
        {ordini.map((value, i) => {
          return (
            <ItemOrdine
              key={i}
              onClick={() => {
                DigitalMenuService.setStato(value.ordineId);
              }}
              ordine={value}
            >
              {value.ordineId} STATO: {value.stato}{" "}
            </ItemOrdine>
          );
        })}
      </Content>
      <Footer></Footer>
    </Layout>
  );
}

export default VistaOrdini;
