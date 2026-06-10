clear, clc,close all

f1=figure;
A = full(gallery('poisson',5));
b=ones(1,length(A));
b=b.';
tol=1e-7;
maxit=1000;
[x,flag,rr,it,rv] = jacobi(A,b,tol,maxit);
loglog(rv);
hold on;
[x,flag,rr,it,rv] = gauss_seidel(A,b,tol,maxit);
loglog(rv);
[x,flag,rr,it,rv] = pcg(A,b,tol,maxit);
loglog(rv);
legend("Jacobi","GS","pcg");
xlabel("počet iterací");
ylabel("relativní reziduum");


f2=figure;
A = full(gallery('lehmer',20));
b=ones(1,length(A));
b=b.';
[x,flag,rr,it,rv] = jacobi(A,b,tol,maxit);
%loglog(rv);
%hold on;
[x,flag,rr,it,rv] = gauss_seidel(A,b,tol,maxit);
loglog(rv);
hold on;
[x,flag,rr,it,rv] = pcg(A,b,tol,maxit);
loglog(rv);
legend("GS","pcg");
xlabel("počet iterací");
ylabel("relativní reziduum");

f3=figure;
A = full(gallery('dorr',5));
b=ones(1,length(A));
b=b.';
[x,flag,rr,it,rv] = jacobi(A,b,tol,maxit);
loglog(rv);
hold on;
[x,flag,rr,it,rv] = gauss_seidel(A,b,tol,maxit);
loglog(rv);
[x,flag,rr,it,rv] = pcg(A,b,tol,maxit);
%loglog(rv);
legend("Jacobi","GS");
xlabel("počet iterací");
ylabel("relativní reziduum");

f1.Name="Poison";
f2.Name="Lehmer";
f3.Name="Dorr";

saveas(f1,"graph_poisson.png");
saveas(f2,"graph_lehmer.png");
saveas(f3,"graph_dorr.png");