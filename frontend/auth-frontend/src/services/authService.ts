import axios from "axios";

const API = axios.create({
  baseURL: "http://localhost:8081",
});

export default API;

export const registerUser = (data: any) => {
  return API.post("/auth/register", data);
};

export const loginUser = (data: any) => {
  return API.post("/auth/login", data);
};

export const getUser = (token: any) => {
  return API.post("/auth/login", token);
};

API.interceptors.request.use((config) => {
  const token = localStorage.getItem("token");
  if (token) {
    config.headers.Authorization = `Bearer ${token}`;
  }

  return config;
});