import React from 'react';
import { Row, Col, Card } from 'antd';

function ItemProdotto(props) {
    return (
        <Card
            onClick={() => (alert("cioa"))}
            hoverable
            bodyStyle ={{padding:"5px"}}
            style={{ display:"inline-block", width: "200px", height: "200px", margin:"5px" , padding:"0px" }}>
            <Row>
                <Col>
                    <img src={"https://i0.wp.com/www.sicilianicreativiincucina.it/wp-content/uploads/2018/06/linguine-con-vongole.jpg?fit=700%2C686&ssl=1"}
                        style={{
                            width: "80%", display: "block", marginLeft: "auto",
                            marginRight: "auto"
                        }}></img>
                </Col>
            </Row>
            <Row style={{margin:"5px"}} >
                <Col style={{margin:"auto"}}>
                    <h3>Titolo prodotto{props.nome}</h3>
                </Col>
            </Row>

            <div>
                <div style={{width:"80px",height:"30px",backgroundColor:"orange",marginLeft:"120px",marginTop:"-15px",position:"relative", zindex:"1000"}} >
                        <h3>15,55€{props.prezzo}</h3>
                </div>
            </div>
        </Card>
    );
}

export default ItemProdotto;