#!/bin/bash

# Build script for main.tex

MAIN_FILE="main"

if [ "$1" == "clean" ]; then
    echo "Cleaning auxiliary files..."
    rm -f *.aux *.log *.out *.toc *.lof *.lot *.fls *.fdb_latexmk *.synctex.gz *.bbl *.blg
    echo "Clean complete."
    exit 0
fi

echo "Compiling $MAIN_FILE.tex..."

# Check if latexmk is available (best option for multiple passes)
if command -v latexmk >/dev/null 2>&1; then
    latexmk -pdf -interaction=nonstopmode "$MAIN_FILE.tex"
else
    echo "latexmk not found, using pdflatex and bibtex as fallback..."
    pdflatex -interaction=nonstopmode "$MAIN_FILE.tex"
    bibtex "$MAIN_FILE"
    pdflatex -interaction=nonstopmode "$MAIN_FILE.tex"
    pdflatex -interaction=nonstopmode "$MAIN_FILE.tex"
fi

echo "Cleaning up auxiliary files..."
rm -f *.aux *.log *.out *.toc *.lof *.lot *.fls *.fdb_latexmk *.synctex.gz *.bbl *.blg

echo "Done! The output is $MAIN_FILE.pdf"
