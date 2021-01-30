import axios from "axios";

const IP = "localhost";

const URL = "http://" + IP + ":8080/DigitalMenu_Server/";

class DigitalMenuService {
  getAllProdottiByCategoria(id) {
    return axios.get(URL + "GestioneCategoria", {
      params: {
        id: id,
      },
    });
  }

  getProdotto(id) {
    return axios.get(URL + "GestioneProdotto", {
      params: {
        idP: id,
      },
    });
  }

  getCategorie() {
    return axios.post(URL + "VisualizzaCat", {
      params: {
        _limit: 10,
      },
    });
  }

  getOrdini() {
    return axios.post(URL + "VisualizzaOrdiniPagati", {});
  }

  setStato(id) {
    return axios.get(URL + "GestoreStatoOrdine", {
      params: {
        id: id,
      },
    });
  }
  /* SEND*/

  inviaProva(json, id) {
    axios({
      method: "post",
      url: URL + "GestioneOrdine?idPagamento=" + id,
      headers: {},
      data: json,
    });
  }
}
export default new DigitalMenuService();
