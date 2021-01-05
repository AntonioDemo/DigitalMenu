import React from 'react';
// import ProvaCarousel from '../components/ProvaCarousel'; import
// VerticalCarousel from '../components/VerticalCarousel'; import ItemOrdine
// from '../components/ItemOrdine'; import DettaglioPiatto from
// '../components/DettaglioPiatto';
import {Layout} from 'antd';
import ItemCategoria from '../components/ItemCategoria';
import ItemCarrello from '../components/ItemCarrello';
import ItemProdotto from '../components/ItemProdotto';
import DigitalMenuService from '../services/DigitalMenuService';
//import Temp0Service from '../services/Temp0Service';
const {Header, Footer, Sider, Content} = Layout;

function Categoria() {

    DigitalMenuService
        .getProva()
        .then((res) => {
            console.log(res.data);
        });

    //SEND
    DigitalMenuService
        .inviaProva()
        .then((response) => response.data)
        .then((json) => console.log(json));

    return (true);
};

function VistaMenu() {
    return (
        <Layout style={{
            height: "100vh"
        }}>
            <Header
                style={{
                padding: "0",
                height: "auto"
            }}></Header>
            <Layout>
                <Categoria/>
                <Sider
                    width={"15%"}
                    style={{
                    overflow: 'auto'
                }}>
                    <ItemCategoria/>
                    <ItemCategoria/>
                    <ItemCategoria/>
                    <ItemCategoria/>
                    <ItemCategoria/>
                    <ItemCategoria/>
                    <ItemCategoria/>
                    <ItemCategoria/>
                    <ItemCategoria/>
                    <ItemCategoria/>
                    <ItemCategoria/>
                    <ItemCategoria/>
                    <ItemCategoria/>
                    <ItemCategoria/>

                </Sider>
                <Content style={{
                    overflow: 'auto'
                }}>
                    <ItemProdotto/>
                    <ItemProdotto/>
                    <ItemProdotto/>
                    <ItemProdotto/>
                    <ItemProdotto/>
                    <ItemProdotto/>
                    <ItemProdotto/>
                    <ItemProdotto/>
                    <ItemProdotto/>
                    <ItemProdotto/>
                    <ItemProdotto/>
                    <ItemProdotto/>
                    <ItemProdotto/>
                    <ItemProdotto/>
                    <ItemProdotto/>
                    <ItemProdotto/>
                    <ItemProdotto/>
                    <ItemProdotto/>
                    <ItemProdotto/>
                    <ItemProdotto/>
                    <ItemProdotto/>
                    <ItemProdotto/>
                    <ItemProdotto/>
                    <ItemProdotto/>
                    <ItemProdotto/>
                    <ItemProdotto/>
                    <ItemProdotto/>
                </Content>

            </Layout>
            <Footer
                style={{
                height: "25vh",
                backgroundColor: "orange",
                padding: "5px"
            }}>
                <ItemCarrello/>
            </Footer>
        </Layout>
    );
};

export default VistaMenu;