import React, { useState, useEffect } from "react";
import ItemCategoria from "../components/ItemCategoria";
import DigitalMenuService from "../services/DigitalMenuService";

function VistaCategoria() {
  const [categorie, setCategorie] = useState([]);

  useEffect(() => {
    let a = DigitalMenuService.getCategorie();
    a.then((res) => setCategorie(res.data));
  }, []);

  return (
    <div>
      {categorie.map((value, i) => {
        return (
          <ItemCategoria
            key={i}
            categoriaId={value.categoriaId}
            nome={value.nomeCat}
            foto={value.foto}
          />
        );
      })}
    </div>
  );
}

export default VistaCategoria;
