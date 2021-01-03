import React from 'react';
import { Row, Col, Card } from 'antd';

function ItemCarrello(props) {
    return (
        <Row
            style={{ width: "100%", height:"100%" }}>
            
            <Row
             style={{ width: "100%", height:"100%" }}>
                <Col  style={{ width:"80%",  backgroundColor:"blue" }} >
                    <p>piatto N</p>
                    <p>Prezzo €</p>
                    <p>stato</p>
                </Col>

                <Col  style={{width:"20%",backgroundColor:"red" }} >
                        
                </Col>
               
            </Row>
        </Row>
    );
}

export default ItemCarrello;