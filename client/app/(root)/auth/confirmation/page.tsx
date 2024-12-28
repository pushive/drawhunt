'use client';

import React, { useEffect, useState } from 'react';
import { AuthCard } from '../components/AuthCard';
import { useRouter, useSearchParams } from 'next/navigation';
import { confirmNewUser } from '@/app/api';

const ConfirmationPage = () => {
  const [isLoading, setIsLoading] = useState<boolean>(true);
  const router = useRouter();
  const searchParams = useSearchParams();
  const token = searchParams.get('token');

  useEffect(() => {
    const confirm = async (token: string) => {
      try {
        await confirmNewUser(token);
        setIsLoading(false);
      } catch (error) {
        console.error(error);
        router.push('/auth/login');
      }
    };

    if (token) {
      confirm(token);
    } else {
      router.push('/auth/login');
    }
  }, [token, router]);

  if (isLoading) {
    <></>;
  }

  return (
    <AuthCard title="Successfully Registered!">
      <div>Please log in from the login page.</div>
      <button
        type="submit"
        className="w-full mt-5 bg-green-500 text-white px-2 py-1"
        onClick={() => {
          router.push('/auth/login');
        }}
      >
        Login Page
      </button>
    </AuthCard>
  );
};

export default ConfirmationPage;
