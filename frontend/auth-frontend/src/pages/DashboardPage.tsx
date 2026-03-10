function DashboardPage() {

  const role = localStorage.getItem("role");

  return (
    <div className="p-10">
      <button
        onClick={() => {
          localStorage.removeItem("token");
          localStorage.removeItem("role");
          window.location.href = "/";
        }}
        className="mb-6 bg-black text-white px-4 py-2 rounded"
      >
        Logout
      </button>

      <h1 className="text-3xl font-bold mb-6">
        Dashboard
      </h1>

      <div className="grid grid-cols-2 gap-6">
        {/*|| role === "ADMIN"  */}
        {(role === "USER") && (
          <div className="p-6 border rounded shadow bg-blue-50">
            User Content
          </div>
        )}

        {role === "ADMIN" && (
          <div className="p-6 border rounded shadow bg-red-50">
            Admin Content
          </div>
        )}

      </div>

    </div>
  );
}

export default DashboardPage;