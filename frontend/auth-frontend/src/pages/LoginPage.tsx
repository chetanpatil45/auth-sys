import { useForm } from "react-hook-form";
import { Link, useNavigate } from "react-router-dom";
import { loginUser } from "../services/authService";
import { getUser } from "../services/authService";

type LoginForm = {
  email: string;
  password: string;
};

function LoginPage() {
  const { register, handleSubmit } = useForm<LoginForm>();
  const navigate = useNavigate();

  const onSubmit = async (data: LoginForm) => {
    try {
      const response = await loginUser(data);
      console.log("LOGIN RESPONSE:", response.data);
      
      const token = response.data.jwt;
      console.log("TOKEN:", token);
      
      localStorage.setItem("token", token);
      console.log("LOCAL TOKEN:", localStorage.getItem("token"));
      
      const user = await getUser();
      localStorage.setItem("role", user.data.role);

      console.log(response);
      console.log(user);
      navigate("/dashboard");

    } catch (error) {
      console.log(error);
      alert("Invalid credentials");
    }
  };

  return (
    <div className="flex items-center justify-center h-screen bg-gray-100">

      <form
        onSubmit={handleSubmit(onSubmit)}
        className="bg-white p-6 rounded shadow-md w-96"
      >

        <h2 className="text-2xl font-bold mb-4 text-center">
          Login
        </h2>

        <input
          {...register("email")}
          placeholder="Email"
          className="border p-2 w-full mb-3"
        />

        <input
          {...register("password")}
          type="password"
          placeholder="Password"
          className="border p-2 w-full mb-4"
        />

        <button className="bg-blue-500 text-white w-full p-2 rounded">
          Login
        </button>

        <p className="text-sm mt-4 text-center">
          Don't have an account?
          <Link to="/register" className="text-blue-500 ml-1">
            Register
          </Link>
        </p>
      </form>
    </div>
  );
}
export default LoginPage;