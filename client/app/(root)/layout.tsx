'use client';

import React from 'react';
import { Header } from '../components/ui';
import { usePathname } from 'next/navigation';

const Layout = ({ children }: Readonly<{ children: React.ReactNode }>) => {
  const pathname = usePathname();
  const isAuthRoute = pathname.startsWith('/auth');
  return (
    <>
      {!isAuthRoute && <Header />}
      {children}
    </>
  );
};

export default Layout;
