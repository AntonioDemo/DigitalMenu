import React from "react";
import { Row, Col, Card, Button } from "antd";
import { Layout } from "antd";
import ItemRigaProdotto from "../components/ItemRigaProdotto";
const { Header, Footer, Sider, Content } = Layout;

function VistaCarrello(props) {
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
                <ItemRigaProdotto />
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
