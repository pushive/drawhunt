const LoginPage = () => {
  return (
    <div className="flex justify-center">
      <div className="w-[300px] mt-[100px] p-5 flex flex-col items-center gap-3 border">
        <div className="text-xl font-semibold">Login</div>
        <input
          type="text"
          placeholder="Username"
          className="w-full border px-2 py-1"
        />
        <input
          type="text"
          placeholder="Password"
          className="w-full border px-2 py-1"
        />
        <input
          type="email"
          placeholder="E-mail"
          className="w-full border px-2 py-1"
        />
        <button className="w-full bg-blue-500 text-white px-2 py-1">
          Login
        </button>
      </div>
    </div>
  );
};

export default LoginPage;
