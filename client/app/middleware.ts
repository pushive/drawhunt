import { NextResponse } from 'next/server';

export const middleware = () => {
  console.log('middleware');
  return NextResponse.next();
};

export const config = {
  matcher: '/:path*',
};
