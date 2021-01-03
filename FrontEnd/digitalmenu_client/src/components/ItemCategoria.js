import React from 'react';
import { Row, Col, Card } from 'antd';

function ItemCategoria(props) {
    return (
        <Card
            onClick={() => (alert("cioa"))}
            hoverable
            style={{ marginBottom: "10px", marginTop: "10px", marginRight: "10px", marginLeft: "5px" }}>
            <Row>
                <Col span={18} push={6}>
                    <p>Testo</p>
                </Col>
                <Col span={6} pull={18}>
                    <img src={"https://i0.wp.com/www.sicilianicreativiincucina.it/wp-content/uploads/2018/06/linguine-con-vongole.jpg?fit=700%2C686&ssl=1"}
                        style={{
                            width: "90%", display: "block", marginLeft: "auto",
                            marginRight: "auto", marginTop: "20px"
                        }}></img>
                </Col>
            </Row>
        </Card>
    );
}

export default ItemCategoria;