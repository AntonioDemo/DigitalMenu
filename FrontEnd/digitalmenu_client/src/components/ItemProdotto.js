import React from 'react';
import { Row, Col, Card } from 'antd';

function ItemProdotto(props) {
    return (
        <Card
            onClick={() => (alert("cioa"))}
            hoverable
            style={{ display:"inline-block", width: "200px", height: "200px", marginBottom: "5px", marginTop: "5px", marginRight: "5px", marginLeft: "5px" }}>
            <Row>
                <Col span={15} push={9}>
                    <p>{props.nome}</p>
                    <p>{props.prezzo}€</p>
                </Col>
                <Col span={9} pull={15}>
                    <img src={"https://i0.wp.com/www.sicilianicreativiincucina.it/wp-content/uploads/2018/06/linguine-con-vongole.jpg?fit=700%2C686&ssl=1"}
                        style={{
                            width: "100%", display: "block", marginLeft: "auto",
                            marginRight: "auto"
                        }}></img>
                </Col>
            </Row>
        </Card>
    );
}

export default ItemProdotto;