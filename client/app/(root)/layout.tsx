import React from 'react';
import { Header } from '../components/ui';

const Layout = ({ children }: Readonly<{ children: React.ReactNode }>) => {
  return (
    <div>
      <Header />
      {children}
    </div>
  );
};

export default Layout;
