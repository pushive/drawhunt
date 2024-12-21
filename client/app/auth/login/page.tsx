'use cliennt';

import Link from 'next/link';
import { AuthCard } from '../components/AuthCard';

const LoginPage = () => {
  return (
    <AuthCard title="Login">
      <form className="w-full flex flex-col gap-3">
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
        <button
          type="submit"
          className="w-full mt-5 bg-blue-500 text-white px-2 py-1"
        >
          Login
        </button>
      </form>
      <div className="w-full flex justify-end">
        <Link href={'/auth/sign-up'}>
          <div className="text-blue-500 hover:underline">Sign Up</div>
        </Link>
      </div>
    </AuthCard>
  );
};

export default LoginPage;
