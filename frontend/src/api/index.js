import axios from "axios";

// axios 객체 생성
export default axios.create({
  // baseURL: "http://i7a703.p.ssafy.io:8080/",
  // baseURL: "http://192.168.195.105:8080/api/",
  // baseURL: "http://localhost:8000/",
  baseURL: "http://localhost:8181/api/",
  headers: {
    "Content-type": "application/json",
  },
});
