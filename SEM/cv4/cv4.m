clc;clear;
tol=1e-17;
iter=1000;

% 25 průchodů smyčky
A=[1 1 0; 1 1 1; 0 1 1];
in=[1;2;1];
[vece,lamb]=eig(A);
eiglamb=max(abs(diag(lamb))); % +-2.4142
[vec,lamb]=mocninna_metoda(A,in,tol,iter); % vec=[0.5000 0.7071 0.5000],lamb=2.4142
abs(lamb)-eiglamb; % 0
A*vec-lamb*vec % 1.0e-09 *[-0.3812 0.0000 0.3812]

% 99 průchodů smyčky
A=[1.5 -6.5 6.5; 1 -6 6.5; 1 -1 1.5];
in=[1;0;0];
[vece,lamb]=eig(A);
eiglamb=max(abs(diag(lamb))); % +-5.0000
[vec,lamb]=mocninna_metoda(A,in,tol,iter); % vec=[-0.7071 -0.7071 0.0000], lamb=-5.0000
abs(lamb)-eiglamb; % 8.8818e-16
A*vec-lamb*vec; % 1.0e-15 * [0.4441 0.4441 0.0645]

% 92 průchodů smyčky
M=[0 1/2 1/4 1 1/3; 1/3 0 1/4 0 0; 1/3 1/2 0 0 1/3; 1/3 0 1/4 0 1/3; 0 0 1/4 0 0];
chars=['A' 'B' 'C' 'D' 'E'];
in=[9999;9999;9999;9999;9998];
[vece,lamb]=eig(M);
eiglamb=max(abs(diag(lamb))); % +-1.0000
[vec,lambda]=mocninna_metoda(M,in,tol,iter); % vec=[0.7141 0.3508 0.4510 0.3884 0.1128], lambda=1.0000
abs(lambda)-eiglamb; % 2.2204e-16
M*vec-lambda*vec; % 1.0e-15 * [0.2220 -0.1110 -0.0555 -0.1665 0.0278]
[~,svec]=sort(transpose(vec)); % [5 2 4 3 1]
webs=chars(svec); % EBDCA

[vec,lambda]=mocninna_metoda([1 0; 0 1],[1;0],tol,iter)
[vece,lamb]=eig([1 0; 0 1])