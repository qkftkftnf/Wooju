FROM node:16-alpine

WORKDIR /app

COPY package*.json ./

RUN npm ci

COPY ./ ./

RUN npm install --dev

EXPOSE 5173

CMD ["npm", "run", "dev"]