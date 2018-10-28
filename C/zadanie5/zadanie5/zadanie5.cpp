#include <stdio.h>

int main()
{
	int temp, max, min, c = 0, c_max, c_min;

	printf("Podaj liczbe: ");
	scanf_s("%d", &temp);
	if (temp >= 0) {
		c += 1;
		max = temp;
		min = temp;
	}
	else {
		printf("Nie podano zadnej dodatniej liczby\n");
	}

	while (1==1)
	{
		printf("Podaj liczbe: ");
		scanf_s("%d", &temp);
		if (temp < 0) {
			break;
		}

		c += 1;

		if (temp > max)
		{
			max = temp;
			c_max = c;
		}
		else if (temp < max)
		{
			min = temp;
			c_min = c;
		}

	}
	printf("Maksymalny element to: %d, index: %d\n", max, c_max);
	printf("Minimalny element to: %d, index: %d\n", min, c_min);
}
