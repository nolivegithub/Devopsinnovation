FROM node:18-alpine

WORKDIR /app

COPY . .

RUN npm install

RUN npm run build

EXPOSE 3000

# Serve with a static server
RUN npm install -g serve

CMD ["serve", "-s", "build", "-l", "3000"]