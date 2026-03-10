import axios from "axios";

const API = axios.create({
  baseURL: "http://localhost:8081",
});

export default API;

export const registerUser = (data: any) => {
  return API.post("/api/auth/register", data);
};

export const loginUser = (data: any) => {
  return API.post("/api/auth/login", data);
};

export const getUser = () => {
  return API.get("/api/user/me");
};

API.interceptors.request.use((config) => {
  const token = localStorage.getItem("token");

  if (token && token !== "null") {
    config.headers.Authorization = `Bearer ${token}`;
  }
  return config;
});