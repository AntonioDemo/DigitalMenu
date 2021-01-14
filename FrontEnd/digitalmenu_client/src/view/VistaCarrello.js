import React, { useContext, useState } from "react";
import { Row, Col, Button, Modal, AutoComplete } from "antd";
import { Layout } from "antd";
import ItemRigaProdotto from "../components/ItemRigaProdotto";
import CarrelloContext from "../context/CarrelloContext";
import DigitalMenuService from "../services/DigitalMenuService";
const { Content } = Layout;

function countDown(messaggio) {
  let secondsToGo = 5;
  const modal = Modal.success({
    title: messaggio,
    content: `Ritira il tuo ordine appena è pronto.`,
  });
  const timer = setInterval(() => {
    secondsToGo -= 1;
  }, 1000);
  setTimeout(() => {
    clearInterval(timer);
    modal.destroy();
  }, secondsToGo * 1000);
}

function VistaCarrello(props) {
  const [carrelloContext, setContext] = useContext(CarrelloContext);
  const [visible, setVisible] = useState(false);
  console.log("VISTACARRELLO CONTEXT=", carrelloContext);
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
                {carrelloContext.listaProdotti !== undefined &&
                  carrelloContext.listaProdotti.map((value, i) => {
                    return (
                      <ItemRigaProdotto
                        key={i}
                        prodottoId={value.prodotto.prodottoId}
                        nome={value.prodotto.nome}
                        qta={value.quantita}
                        prezzo={value.prodotto.prezzo}
                      />
                    );
                  })}
                {console.log(
                  "V.CARRELLO CONTEXT DOPO RENDER ITEMpRODOT ",
                  carrelloContext
                )}
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
                    <h1>{carrelloContext.prezzoTotale}€</h1>
                  </Col>

                  <Col
                    style={{
                      width: "100%",
                      height: "50%",
                    }}
                  >
                    <Button
                      onClick={() => {
                        setVisible(true);
                      }}
                      type="primary"
                      style={{
                        width: "90%",
                        height: "90%",
                      }}
                    >
                      PAGA
                    </Button>

                    <Modal
                      title=""
                      centered
                      visible={visible}
                      onOk={() => setVisible(false)}
                      onCancel={() => setVisible(false)}
                      width={1000}
                      style={{ textAlign: "center" }}
                      okButtonProps={{ hidden: true }}
                      cancelButtonProps={{ hidden: true }}
                    >
                      <Button
                        onClick={() => {
                          let b = DigitalMenuService.inviaProva(
                            carrelloContext,
                            1
                          );
                          setVisible(false);
                          let Carrello = {
                            categoriaSelezionata: 1,
                            prodottoSelezionato: 1,
                            metodoDiPagamento: 0,
                            prezzoTotale: 0.0,
                            listaProdotti: [],
                          };

                          setContext(Carrello);
                          countDown("Completa il pagamento alla cassa");
                        }}
                        type="primary"
                        style={{
                          marginRight: "5px",
                          width: "250px",
                          height: "250px",
                        }}
                      >
                        PAGA IN CONTANTI
                      </Button>
                      <Button
                        onClick={() => {
                          let b = DigitalMenuService.inviaProva(
                            carrelloContext,
                            0
                          );
                          setVisible(false);

                          let Carrello = {
                            categoriaSelezionata: 1,
                            prodottoSelezionato: 1,
                            metodoDiPagamento: 0,
                            prezzoTotale: 0.0,
                            listaProdotti: [],
                          };

                          setContext(Carrello);

                          console.log(
                            "CARRELLO CONTEXT ITEMPRODOTTO",
                            carrelloContext
                          );

                          countDown("Pagamento effettuato con successo");
                        }}
                        type="primary"
                        style={{
                          marginLeft: "5px",
                          width: "250px",
                          height: "250px",
                        }}
                      >
                        PAGA CON CARTA
                      </Button>
                    </Modal>
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
