# Angular Project Description

## Overview
This project is an Angular application that uses the Route and Http modules to perform CRUD operations for albums and display them on various pages.

## Pages
- `/home`: A static markup page.
- `/about`: A static markup page.
- `/albums`: A page that displays a list of albums fetched using the HTTP module. Each album has a delete button and can be clicked to navigate to the album detail page.
- `/albums/:id`: A page that displays information about a selected album, including an editable input for changing the album title and a link to the album photos page.
- `/albums/:id/photos`: A page that displays all images for a selected album.
- Root url: Redirects to `/home`.

## Components
- Home Component
- About Component
- Albums Component
- Album Detail Component
- Album Photos Component

## Functionality
- CRUD operations for albums.
- Albums and photos are fetched using the HTTP module and passed to components through `albums.service.ts`.
- Components use Observable.