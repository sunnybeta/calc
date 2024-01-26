FROM node:18-alpine
WORKDIR /app
COPY . .
RUN ls
RUN npm i
RUN npm run build
EXPOSE 4173
CMD ["npm","run","preview"]
