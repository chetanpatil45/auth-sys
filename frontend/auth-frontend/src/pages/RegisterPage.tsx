import { useForm } from "react-hook-form";
import { Link } from "react-router-dom";
import { registerUser } from "../services/authService";

type RegisterForm = {
  name: string;
  email: string;
  password: string;
  role: string;
};

function RegisterPage() {

  const { register, handleSubmit } = useForm<RegisterForm>();

  const onSubmit = async (data: RegisterForm) => {
    try {
      const response = await registerUser(data);

      console.log(response.data);

      alert("Registration successful");

    } catch (error) {

      console.error(error);
      alert("Registration failed");

    }
  };

  return (
    <div className="flex items-center justify-center h-screen bg-gray-100">

      <form
        onSubmit={handleSubmit(onSubmit)}
        className="bg-white p-6 rounded shadow-md w-96"
      >

        <h2 className="text-2xl font-bold mb-4 text-center">
          Register
        </h2>

        <input
          {...register("name")}
          placeholder="Name"
          className="border p-2 w-full mb-3"
        />

        <input
          {...register("email")}
          placeholder="Email"
          className="border p-2 w-full mb-3"
        />

        <input
          {...register("password")}
          type="password"
          placeholder="Password"
          className="border p-2 w-full mb-3"
        />

        <select
          {...register("role")}
          className="border p-2 w-full mb-4"
        >
          <option value="USER">USER</option>
          <option value="ADMIN">ADMIN</option>
        </select>

        <button className="bg-green-500 text-white w-full p-2 rounded">
          Register
        </button>

        <p className="text-sm mt-4 text-center">
          Already have an account?
          <Link to="/" className="text-blue-500 ml-1">
            Login
          </Link>
        </p>

      </form>
    </div>
  );
}

export default RegisterPage;