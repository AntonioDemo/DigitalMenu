import React, { useState } from "react";

import { Modal, Button, Card, Row } from "antd";

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

  return (
    <Row>
      <Card
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
      >
        {props.ordine.listaProdotti.map((value, i) => {
          return <p key={i}>{value.prodotto.nome} </p>;
        })}
        <p>Some contents...</p>
        <p>Some contents...</p>
        <p>Some contents...</p>
      </Modal>
    </Row>
  );
}

export default ItemOrdine;
