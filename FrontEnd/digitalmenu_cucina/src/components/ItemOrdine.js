import React, { useState } from "react";

import { Modal, Button, Card, Row } from "antd";
import { Typography, Space } from "antd";
const { Text, Link, Title } = Typography;

function ItemOrdine(props) {
  const [isModalVisible, setIsModalVisible] = useState(false);

  const showModal = () => {
    setIsModalVisible(true);
  };

  const handleOk = () => {
    props.onClick();
    setIsModalVisible(false);
  };

  const handleCancel = () => {
    setIsModalVisible(false);
  };

  let totale = 0;
  return (
    <>
      <Card
        style={{
          display: "inline-block",
          width: " 30%",
          margin: " 5px",
          padding: "0px",
        }}
        hoverable
        onClick={() => {
          showModal();
        }}
      >
        {props.children}
      </Card>
      <Modal
        title={"Ordine " + props.ordine.ordineId}
        visible={isModalVisible}
        onOk={handleOk}
        onCancel={handleCancel}
        okText="Cambia stato"
        cancelText="Indietro"
      >
        {props.ordine.listaProdotti.map((value, i) => {
          totale += value.prodotto.prezzo;
          return (
            <>
              <Title level={4} key={i}>
                {value.prodotto.nome} x{value.quantita} :{" "}
                {value.prodotto.prezzo}€
              </Title>
              <Text type="danger">
                &emsp; Senza: {value.deleteing != "" && value.deleteing}{" "}
              </Text>
            </>
          );
        })}

        <Title level={4}>Totale: {totale}€</Title>
      </Modal>
    </>
  );
}

export default ItemOrdine;
