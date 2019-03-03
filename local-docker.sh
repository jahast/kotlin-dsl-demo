#!/bin/bash
docker build -t demo . && docker run --rm -p 8000:8000 -t demo