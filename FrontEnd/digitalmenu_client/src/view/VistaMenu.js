import React from "react";
import { Layout } from "antd";
import VistaCategoria from "./VistaCategoria";
import VistaProdotti from "./VistaProdotti";
import VistaCarrello from "./VistaCarrello";
const { Header, Footer, Sider, Content } = Layout;

function VistaMenu() {
  return (
    <Layout
      style={{
        height: "100vh",
      }}
    >
      <Header
        style={{
          padding: "0",
          height: "auto",
        }}
      ></Header>
      <Layout>
        <Sider
          width={"15%"}
          style={{
            overflow: "auto",
          }}
        >
          <VistaCategoria />
        </Sider>
        <Content
          style={{
            overflow: "auto",
          }}
        >
          <VistaProdotti />
        </Content>
      </Layout>
      <Footer
        style={{
          height: "25vh",
          padding: "5px",
        }}
      >
        <VistaCarrello />
      </Footer>
    </Layout>
  );
}

export default VistaMenu;
