import { NextRequest, NextResponse } from 'next/server';

export const middleware = (request: NextRequest) => {
  console.log(request);
  return NextResponse.next();
};

export const config = {
  matcher: ['/api/:path*'],
};
