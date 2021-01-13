import React, { useContext } from "react";
import { Row, Col, Button } from "antd";
import { Layout } from "antd";
import ItemRigaProdotto from "../components/ItemRigaProdotto";
import CarrelloContext from "../context/CarrelloContext";
const { Content } = Layout;

function VistaCarrello(props) {
  const [carrelloContext] = useContext(CarrelloContext);
  return (
    <Layout
      style={{
        height: "100%",
      }}
    >
      <div
        style={{
          height: "auto",
          padding: "0px",
          margin: "0px",
          backgroundColor: "red",
        }}
      >
        <h2
          style={{
            margin: "0px",
            padding: "0px",
          }}
        >
          Carrello
        </h2>
      </div>
      <Layout>
        <Layout>
          <Content
            style={{
              height: "100%",
              backgroundColor: "green",
            }}
          >
            <Row
              style={{
                width: "100%",
                height: "100%",
              }}
            >
              <Col
                style={{
                  width: "80%",
                  height: "100%",
                  backgroundColor: "red",
                  overflow: "auto",
                }}
              >
                {carrelloContext.listaProdotti.map((value, i) => {
                  return (
                    <ItemRigaProdotto
                      key={i}
                      nome={value.prodotto.nome}
                      qta={value.quantita}
                      prezzo={value.prodotto.prezzo}
                    />
                  );
                })}
                {console.log(carrelloContext.listaProdotti)}
              </Col>

              <Col
                style={{
                  width: "20%",
                  backgroundColor: "yellow",
                }}
              >
                <Row
                  style={{
                    width: "100%",
                    height: "100%",
                  }}
                >
                  <Col
                    style={{
                      width: "100%",
                      height: "50%",
                      fontSize: "24px",
                    }}
                  >
                    <h1>Totale:</h1>
                    <h1>100,00€</h1>
                  </Col>

                  <Col
                    style={{
                      width: "100%",
                      height: "50%",
                    }}
                  >
                    <Button
                      type="primary"
                      style={{
                        width: "90%",
                        height: "90%",
                      }}
                    >
                      PAGA
                    </Button>
                  </Col>
                </Row>
              </Col>
            </Row>
          </Content>
        </Layout>
      </Layout>
    </Layout>
  );
}

export default VistaCarrello;
