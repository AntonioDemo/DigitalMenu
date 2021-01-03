import React from 'react';
//import ProvaCarousel from '../components/ProvaCarousel';
//import VerticalCarousel from '../components/VerticalCarousel';
//import ItemOrdine from '../components/ItemOrdine';
//import DettaglioPiatto from '../components/DettaglioPiatto';
import { Layout } from 'antd';
//import Temp0Service from '../services/Temp0Service';
const { Header, Footer, Sider, Content } = Layout;



/*
function Categoria() {


    Service
        .getProva()
        .then((res) => {
            console.log(res.data);
        });


       // console.log(Service.getAllPiattiByCategoria())

    return (
        true
    );

};
*/

function VistaMenu() {
    return (
        <Layout style={{
            height: "100vh"
        }}>
            <Header
                style={{
                    padding: "0",
                    height: "auto"
                }}>
                
            </Header>
            <Layout>
                
                <Sider width={"25%"} >
                   8585585
                </Sider>
                <Content>
                   
                </Content>
                
            </Layout>
            <Footer  style={{
                   height: "25vh",
                   backgroundColor: "orange"
                }} >
                Footer
            </Footer>
        </Layout>
    );
};



export default VistaMenu;