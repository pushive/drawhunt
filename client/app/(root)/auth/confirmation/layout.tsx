import React, { Suspense } from 'react';

const Layout = ({ children }: { children: React.ReactNode }) => {
  return <Suspense fallback={<></>}>{children}</Suspense>;
};

export default Layout;
