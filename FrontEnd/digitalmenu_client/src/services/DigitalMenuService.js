import axios from "axios";

const IP = "127.0.0.1";

//const URL = "http://" + IP + ":8080/";

const URL = "https://jsonplaceholder.typicode.com/";
class DigitalMenuService {
  getProva() {
    return axios.get(URL + "todos/1");
  }

  getAllPiattiByCategoria() {
    return axios.get(URL + "GestionePiatti");
  }

  getCategorie() {
    return axios.get(URL + "todos");
  }

  async getCategorie() {
    return axios.get("https://jsonplaceholder.typicode.com/todos", {
      params: {
        _limit: 10,
      },
    });
  }

  // SEND
  inviaProva() {
    return axios({
      method: "post",
      url: "https://jsonplaceholder.typicode.com/posts",
      data: {
        title: "foo",
        body: "bar",
        userId: 1,
      },
    });
  }
}

export default new DigitalMenuService();
