'use client';
import Link from 'next/link';
import React from 'react';
import { AuthCard } from '../components/AuthCard';
import { useFormik } from 'formik';
import { signUpSchema } from '@/app/schemas';
import { useRouter } from 'next/navigation';

const SignUp = () => {
  const router = useRouter();
  const formik = useFormik({
    initialValues: {
      username: '',
      password: '',
      email: '',
    },
    validationSchema: signUpSchema,
    onSubmit: (values) => {
      if (values.username && values.password && values.email) {
        try {
          // await signup(username, password, email);
          router.push('/auth/sign-up/confirmation');
        } catch (error) {
          console.error(error);
        }
      }
    },
  });

  return (
    <AuthCard title="Sign Up">
      <form
        className="w-full flex flex-col gap-3"
        onSubmit={formik.handleSubmit}
      >
        <div>
          <input
            type="text"
            placeholder="Username"
            className="w-full border px-2 py-1"
            {...formik.getFieldProps('username')}
          />
          {formik.errors.username && formik.touched.username && (
            <div className="text-sm text-red-500">{formik.errors.username}</div>
          )}
        </div>
        <div>
          <input
            type="text"
            placeholder="Password"
            className="w-full border px-2 py-1"
            {...formik.getFieldProps('password')}
          />
          {formik.errors.password && formik.touched.password && (
            <div className="text-sm text-red-500">{formik.errors.password}</div>
          )}
        </div>
        <div>
          <input
            type="email"
            placeholder="E-mail"
            className="w-full border px-2 py-1"
            {...formik.getFieldProps('email')}
          />
          {formik.errors.email && formik.touched.email && (
            <div className="text-sm text-red-500">{formik.errors.email}</div>
          )}
        </div>
        <button
          type="submit"
          className="w-full mt-5 bg-blue-500 text-white px-2 py-1"
        >
          Sign Up
        </button>
      </form>
      <div className="w-full flex justify-end">
        <Link href={'/auth/login'}>
          <div className="text-blue-500 hover:underline">Login</div>
        </Link>
      </div>
    </AuthCard>
  );
};
export default SignUp;
