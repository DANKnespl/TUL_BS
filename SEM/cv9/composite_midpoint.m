function I = composite_midpoint(f,a,b,n)
    I=0*n;
    for j=1:length(n)
        dh=(b-a)./n(j); %2/n
        x=a+dh*(0:n(j));
        for i=(1:length(x)-1)
            I(j)=I(j)+f((x(i)+x(i+1))/2);
        end
        I(j)=dh*I(j);
    end
end