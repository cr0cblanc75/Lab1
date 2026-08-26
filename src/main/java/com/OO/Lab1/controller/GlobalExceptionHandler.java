package com.OO.Lab1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {

        String html = """
        <html>
            <head>
                <style>
                    body {
                        font-family: Arial, sans-serif;
                        background-color: #f5f5f5;
                        display: flex;
                        justify-content: center;
                        align-items: center;
                        height: 100vh;
                        margin: 0;
                    }

                    .error-container {
                        background-color: white;
                        padding: 40px;
                        border-radius: 12px;
                        box-shadow: 0 4px 15px rgba(0, 0, 0, 0.15);
                        text-align: center;
                        max-width: 600px;
                    }

                    h1 {
                        color: #d32f2f;
                        margin-bottom: 20px;
                    }

                    p {
                        color: #555;
                        font-size: 18px;
                    }
                </style>
            </head>

            <body>
                <div class="error-container">
                    <h1>Seems like you found an Error</h1>
                    <p>%s</p>
                </div>
            </body>
        </html>
        """.formatted(e.getMessage());

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .header("Content-Type", "text/html")
                .body(html);
    }
}
