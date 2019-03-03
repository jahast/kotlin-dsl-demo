#!/bin/bash
curl -H "Content-Type: application/json" \
  -X POST \
  -d @test.json \
  http://localhost:8000/api/v1/discount/