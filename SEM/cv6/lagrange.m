function yq = lagrange(x,y,xq)
%P=zeros(1,length(x));
yq=0;
   for i=1:length(x)
            a=y(i);
        %L=[1];
        for j=1:length(x)
            if i==j
            else
            a=a.*(xq-x(j))/(x(i)-x(j));
            %L=conv(L,[1 -x(j)]);
            end
        end
        yq=yq+a;
        %P=L.*a+P;
    end
    %yq=polyval(P,xq);
end