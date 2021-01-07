import React, { useState, useEffect } from "react";
import ItemProdotto from "../components/ItemProdotto";
import DigitalMenuService from "../services/DigitalMenuService";

function VistaProdotti() {
  const [prodotti, setProdotti] = useState([]);

  useEffect(() => {
    let a = DigitalMenuService.getAllProdottiByCategoria();
    a.then((res) => setProdotti(res.data));
  }, []);

  return (
    <div>
      {prodotti.map((value, i) => {
        return <ItemProdotto key={i} nome={value.id} />;
      })}
    </div>
  );
}

export default VistaProdotti;
